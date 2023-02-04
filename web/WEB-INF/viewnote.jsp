<%-- 
    Document   : viewNote
    Created on : 3-Feb-2023, 8:03:06 PM
    Author     : Ray
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <p><strong>Title: </strong>${note.title}</p>
        <p><strong>Contents: </strong>${note.contents}</p>
        <a href="note?edit=value">Edit</a>
    </body>
</html>
