<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@ include file="header.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">UsersCRUD</h1>
        <a href="${pageContext.request.contextPath}/user/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                class="fas fa-download fa-sm text-white-50"></i> Lista Uzytkownikow</a>
    </div>

</div>
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Dodaj Uzytkownika</h6>
    </div>
    <div class="card-body">

        <form name="infoAboutUser" class="user" onsubmit="return validation()"  method="post">
            <div class="form-group">
                Nazwa
                <br><input type="text" class="form-control form-control-user" name="name" value="<c:out value="${userToEdit.userName}"/>">
                <br>Email
                <br><input type="email" name="email" class="form-control form-control-user" id="exampleInputEmail" aria-describedby="emailHelp" value="<c:out value="${userToEdit.email}"/>">
                <br>Password
                <br><input type="password" name="password" class="form-control form-control-user" placeholder="Haslo Uzytkownika">
            </div>
            <button type="submit" class="btn btn-sm btn-primary shadow-sm">Edytuj</button>


        </form>

    </div>

    <script>
        function validation(){
            var x = document.forms["infoAboutUser"]["password"].value;
            if(x===""){
                alert("Password must be filled out");
                return false;
            }
        }

    </script>

<%@ include file="footer.jsp" %>