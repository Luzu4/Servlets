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
          <tbody>

            <tr class="odd">
              <td>Id</td>
              <td class="sorting_1"><c:out value="${userToShow.id}"/></td>

            </tr>
          <tr>
            <td>Nazwa Uzytkownika</td>
            <td><c:out value="${userToShow.userName}"/></td>

          </tr>
          <tr>
            <td>Email</td>
            <td><c:out value="${userToShow.email}"/></td>
          </tr>

          </tbody>
        </table></div>
        </div>
        </div>
      </div>

    </div>






<%@ include file="footer.jsp" %>