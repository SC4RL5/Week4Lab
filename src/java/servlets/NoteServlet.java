package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author Ray
 */
public class NoteServlet extends HttpServlet {

      
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        String title;
        String contents;
        try ( // to read files
                BufferedReader br = new BufferedReader(new FileReader(new File(path)))) {
            String currentLine;
            title = "";
            contents = "";
            while((currentLine = br.readLine()) != null){
                title = currentLine;
                contents = br.readLine();
            }
        }
        
        Note note = new Note(title, contents);
        request.setAttribute("note", note);
        
        String parameter = request.getParameter("edit");
        
        String jspPath;
        
        if (parameter != null){
            jspPath = "/WEB-INF/editnote.jsp";
        } else {
            jspPath = "/WEB-INF/viewnote.jsp";
        }
        
        getServletContext().getRequestDispatcher(jspPath)
            .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        // to write to a file
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); 

        String title = request.getParameter("title");
        String contents = request.getParameter("contents");
        
        Note note = new Note(title, contents);
        request.setAttribute("note", note);
        
        pw.println(title);
        pw.println(contents);
        pw.close();
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
    }

}