<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>노트북 견적 내줘!</title>

    <link rel="stylesheet" href="webjars/bootstrap/4.2.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../resources/css/1-col-portfolio.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
     <style>
         .max-small{
             width: auto; height: auto;
             max-height: 300px;
         }
     </style>

</head>

<body >
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand text-danger display-4" href="http://comalmot.com/" style="font-family: '본고딕 KR Heavy'" >노트북 견적 내줘!</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="http://comalmot.com/">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Services</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- Page Content -->
<div class = "container mt-5" >

    <div class="row">

        <div class="col-lg-3 mt-4">
            <div class="list-group " >
                <a href="#" class="list-group-item list-group-item-action text-danger h5" style="font-family: '본고딕 KR Medium'">
                    <span class="fas fa-caret-right"></span> 이용 방법
                </a>
                <a href="http://comalmot.com/view" class="list-group-item list-group-item-action text-danger h5" style="font-family: '본고딕 KR Medium'">
                    <span class="fas fa-caret-right"></span> 노트북 상세검색
                </a>
                <a href="http://comalmot.com/chatbot" class="list-group-item list-group-item-action text-danger h5" style="font-family: '본고딕 KR Medium'">
                    <span class="fas fa-caret-right"></span> 컴잘알에게 말해줘
                </a>
                <a href="http://comalmot.com/query" class="list-group-item list-group-item-action text-danger h5" style="font-family: '본고딕 KR Medium'">
                    <span class="fas fa-caret-right"></span> 개인별 맞춤 솔루션
                </a>
            </div>
        </div>
        <!-- /.col-lg-3 -->


        <div class="col-lg-9">

            <div class="row">
                <!-- Page Heading -->
                <h1 class="my-4" style="font-family: '본고딕 KR Bold'">당신과 가장 어울리는 노트북<br>
                </h1>

                <div class="col-lg-12">
                    <div class="alert alert-warning" role="alert">
                        <h3>진단결과</h3>
                        <h3></h3>
                    </div>
                </div>
                <!-- Project One -->
                <c:forEach var="notebook" items="${notebookPage.content}">
                    <div class="row">
                        <div class="col-md-7">
                            <div class="alert-light " style="width: 500px;height: 300px;text-align: center">
                                <a href="http://comalmot.com/notebookinfo/${notebook.id}">
                                    <img class="img-fluid rounded mb-3 mb-md-0 " src="${notebook.imgurlf}" style="max-height: 300px; width: auto; " alt="">
                                </a>
                            </div>
                        </div>
                        <div class="col-md-5">
                            <h5 class="card-title ">
                                <a href="http://comalmot.com/notebookinfo/${notebook.id}" >${notebook.model}</a>
                            </h5>
                            <h5>${notebook.pricestring} 원</h5>
                            <p>${notebook.cpumanufact} / ${notebook.cpukind} / RAM ${notebook.memorysize} GB / ${notebook.sizeint}인치</p>
                        </div>
                    </div>

                    <hr>
                </c:forEach>
                <!-- /.row -->

            </div>
            <!-- /.row -->

            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">
                    <c:choose>
                        <c:when test="${notebookPage.number eq 0}">
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="?page=1">1</a></li>
                            <li class="page-item"><a class="page-link" href="?page=2">2</a></li>
                            <li class="page-item"><a class="page-link" href="?page=3">3</a></li>
                            <li class="page-item">
                                <a class="page-link" href="?page=2" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:when>
                        <c:when test="${notebookPage.last}">
                            <li class="page-item">
                                <a class="page-link" href="?page=${notebookPage.number}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="?page=${notebookPage.number-1}">${notebookPage.number-1}</a></li>
                            <li class="page-item"><a class="page-link" href="?page=${notebookPage.number}">${notebookPage.number}</a></li>
                            <li class="page-item"><a class="page-link" href="?page=${notebookPage.number+1}">${notebookPage.number+1}</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item">
                                <a class="page-link" href="?page=${notebookPage.number}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="?page=${notebookPage.number}">${notebookPage.number}</a></li>
                            <li class="page-item"><a class="page-link" href="?page=${notebookPage.number+1}">${notebookPage.number+1}</a></li>
                            <li class="page-item"><a class="page-link" href="?page=${notebookPage.number+2}">${notebookPage.number+2}</a></li>
                            <li class="page-item">
                                <a class="page-link" href="?page=${notebookPage.number+2}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </nav>

        </div>
        <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

</div>
<!-- /.container -->

<!-- Footer -->
<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; 컴알못</p>
    </div>
    <!-- /.container -->
</footer>


<script src="/webjars/jquery/2.2.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(function () {
        console.log("jQuery ready");
    });
</script>

</body>

</html>