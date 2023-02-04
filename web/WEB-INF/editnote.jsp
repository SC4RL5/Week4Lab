<%-- 
    Document   : editNote
    Created on : 3-Feb-2023, 8:03:20 PM
    Author     : Ray
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper Edit</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form method="post" action="note">
            Title: <input type="text" name="title" value="${note.title}"><br>
            Contents: <textarea name="contents" rows="5" cols="25" value="${note.contents}">
                ${note.contents}</textarea><br>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
