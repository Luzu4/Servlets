<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@ include file="header.jsp" %>

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">UsersCRUD</h1>
                        <a href="${pageContext.request.contextPath}/user/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                                class="fas fa-download fa-sm text-white-50"></i> Dodaj uzytkownika</a>
                    </div>

                </div>
                <!-- /.container-fluid -->
<div class="col-lg-12 mb-4">

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Lista Uzytkownikow</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4"><div class="row"><div class="col-sm-12 col-md-6"><div class="dataTables_length" id="dataTable_length"></div></div><div class="col-sm-12 col-md-6"><div id="dataTable_filter" class="dataTables_filter"></div></div></div><div class="row"><div class="col-sm-12"><table class="table table-bordered dataTable" id="dataTable" width="100%" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
                    <thead>
                    <tr role="row"><th class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 176px;">Id</th><th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending" style="width: 269px;">Nazwa Uzytkownika</th><th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Office: activate to sort column ascending" style="width: 126px;">Email</th><th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending" style="width: 58px;">Akcja</th></tr>
                    </thead>
                    <tbody>

                    <c:forEach var="user" items="${allUsers}">
                    <tr class="odd">
                        <td class="sorting_1"><c:out value="${user.id}"/></td>
                        <td><c:out value="${user.userName}"/></td>
                        <td><c:out value="${user.email}"/></td>
                        <td><a href="#" onclick="confirmAction(<c:out value="${user.id}"/>)">Usun</a><a href="/user/edit?id=<c:out value="${user.id}"/>"> Edit</a><a href="/user/show?id=<c:out value="${user.id}"/>"> Pokaz</a></td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table></div>
            </div>
        </div>
    </div>

</div>


    <script>

        function confirmAction(userId){
            let confirmAction = confirm("Do you want to delete user with id =" + userId);
            if(confirmAction){
                document.location.href="/user/delete?id=" + userId;
            }else{
                document.location.href="/user/list";
            }
        }
    </script>





<%@ include file="footer.jsp" %>