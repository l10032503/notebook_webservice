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
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">


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


        <div class="col-lg-9 mt-4">

            <div class="row">

                <div class="col-lg-12 mb-2">
                    <form>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    전체
                                </button>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="#">모델명</a>
                                    <a class="dropdown-item" href="#">브랜드명</a>
                                    <div role="separator" class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="#">전체</a>
                                </div>
                            </div>
                            <input type="text" class="form-control" aria-label="Text input with dropdown button">
                            <span class="input-group-btn">
                                <button class="btn btn-outline-secondary" type="button">검색</button>
                            </span>
                        </div>
                    </form>
                </div><!-- /.col-lg-6 -->

                <div class ="col-md-12 text-wrap mb-3">
                    <form method="post" name="sort-table">
                        <table class="table table-bordered">
                            <tr>
                                <TH nowrap="nowrap">브랜드</TH>
                                <TD >
                                    <input TYPE="checkbox" name="brand" value = "samsung">삼성&nbsp&nbsp&nbsp&nbsp
                                    <input type="checkbox" name="brand" value = "lh">LG&nbsp&nbsp&nbsp&nbsp
                                    <input type="checkbox" name="brand" value = "apple">애플&nbsp&nbsp&nbsp&nbsp
                                    <input type="checkbox" name="brand" value = "hp">HP&nbsp&nbsp&nbsp&nbsp
                                    <input type="checkbox" name="brand" value = "dell">DELL&nbsp&nbsp&nbsp&nbsp
                                    <input TYPE="checkbox" name="brand" value = "hansung">한성&nbsp&nbsp&nbsp&nbsp
                                    <input type="checkbox" name="brand" value = "asus">ASUS&nbsp&nbsp&nbsp&nbsp
                                    <input type="checkbox" name="brand" value = "lenova">레노바&nbsp&nbsp&nbsp&nbsp
                                    <input type="checkbox" name="brand" value = "msi">MSI&nbsp&nbsp&nbsp&nbsp
                                    <input type="checkbox" name="brand" value = "gigabyte">기가바이트&nbsp&nbsp&nbsp&nbsp
                                </TD>
                            </tr>
                            <tr>
                                <TH>RAM</TH>
                                <TD>
                                    <input TYPE="checkbox" name="ramsize" value = "twogb">2GB&nbsp&nbsp&nbsp&nbsp
                                    <input type="checkbox" name="ramsize" value = "fourgb">4GB&nbsp&nbsp&nbsp&nbsp
                                    <input type="checkbox" name="ramsize" value = "eightgb">8GB&nbsp&nbsp&nbsp&nbsp
                                    <input type="checkbox" name="ramsize" value = "sixteengb">16GB&nbsp&nbsp&nbsp&nbsp
                                </TD>
                            </tr>
                            <tr>
                                <TH>가격</TH>
                                <TD>
                                    <input TYPE="checkbox" name="price" value = "part1">500,000원 이하&nbsp&nbsp&nbsp&nbsp
                                    <input TYPE="checkbox" name="price" value = "part2">500,000원 ~ 1,000,000원&nbsp&nbsp&nbsp&nbsp
                                    <input TYPE="checkbox" name="price" value = "part3">1,000,000원 ~ 1,500,000원&nbsp&nbsp&nbsp&nbsp
                                    <input TYPE="checkbox" name="price" value = "part4">1,500,000원 ~ 2,000,000원&nbsp&nbsp&nbsp&nbsp
                                    <input TYPE="checkbox" name="price" value = "part5">2,000,000원 이상&nbsp&nbsp&nbsp&nbsp
                                </TD>
                            </tr>
                            <tr>
                                <TH >CPU</TH>
                                <TD style="word-wrap: break-word">
                                    <input style="word-break: keep-all" TYPE="checkbox" name="CPUKind" value = "corei37">코어i3-7세대&nbsp&nbsp&nbsp&nbsp
                                    <input style="word-break: keep-all" TYPE="checkbox" name="CPUKind" value = "corei38">코어i3-8세대&nbsp&nbsp&nbsp&nbsp
                                    <input style="word-break: keep-all" TYPE="checkbox" name="CPUKind" value = "corei55">코어i5-5세대&nbsp&nbsp&nbsp&nbsp
                                    <input style="word-break: keep-all" TYPE="checkbox" name="CPUKind" value = "corei57">코어i5-7세대&nbsp&nbsp&nbsp&nbsp
                                    <input style="word-break: keep-all" TYPE="checkbox" name="CPUKind" value = "corei58">코어i5-8세대&nbsp&nbsp&nbsp&nbsp
                                    <input style="word-break: keep-all" TYPE="checkbox" name="CPUKind" value = "corei77">코어i7-7세대&nbsp&nbsp&nbsp&nbsp
                                    <input style="word-break: keep-all" TYPE="checkbox" name="CPUKind" value = "corei78">코어i7-8세대&nbsp&nbsp&nbsp&nbsp
                                    <input style="word-break: keep-all" TYPE="checkbox" name="CPUKind" value = "corei79">코어i7-9세대&nbsp&nbsp&nbsp&nbsp
                                    <input style="word-break: keep-all" TYPE="checkbox" name="CPUKind" value = "corei98">코어i9-8세대&nbsp&nbsp&nbsp&nbsp
                                    <input style="word-break: keep-all" TYPE="checkbox" name="CPUKind" value = "coreM">코어M&nbsp&nbsp&nbsp&nbsp
                                    <input style="word-break: keep-all" TYPE="checkbox" name="CPUKind" value = "pentiumgold">펜티엄 골드&nbsp&nbsp&nbsp&nbsp
                                    <input style="word-break: keep-all" TYPE="checkbox" name="CPUKind" value = "celeron">셀러론&nbsp&nbsp&nbsp&nbsp
                                    <input style="word-break: keep-all" TYPE="checkbox" name="CPUKind" value = "ryzen3">라이젠 3&nbsp&nbsp&nbsp&nbsp
                                    <input style="word-break: keep-all" TYPE="checkbox" name="CPUKind" value = "ryzen7">라이젠 7&nbsp&nbsp&nbsp&nbsp
                                    <input style="word-break: keep-all" TYPE="checkbox" name="CPUKind" value = "xeon">제온&nbsp&nbsp&nbsp&nbsp
                                </TD>
                            </tr>
                            <tr>
                                <TH>크기</TH>
                                <TD>
                                    <input TYPE="checkbox" name="size" value = "thirteen">13.3인치&nbsp&nbsp&nbsp&nbsp
                                    <input TYPE="checkbox" name="size" value = "fifteen">15인치&nbsp&nbsp&nbsp&nbsp
                                    <input TYPE="checkbox" name="size" value = "fifteenfour">15.4인치&nbsp&nbsp&nbsp&nbsp
                                    <input TYPE="checkbox" name="size" value = "fifteensix">15.6인치&nbsp&nbsp&nbsp&nbsp
                                    <input TYPE="checkbox" name="size" value = "fourteen">14인치&nbsp&nbsp&nbsp&nbsp
                                    <input TYPE="checkbox" name="size" value = "ten">10.9인치&nbsp&nbsp&nbsp&nbsp
                                    <input TYPE="checkbox" name="size" value = "eleven">11.6인치&nbsp&nbsp&nbsp&nbsp
                                    <input TYPE="checkbox" name="size" value = "twelve">12인치&nbsp&nbsp&nbsp&nbsp
                                    <input TYPE="checkbox" name="size" value = "twelvefive">12.5인치&nbsp&nbsp&nbsp&nbsp
                                    <input TYPE="checkbox" name="size" value = "seventeen">17.3인치&nbsp&nbsp&nbsp&nbsp
                                </TD>
                            </tr>
                            <tr>
                                <TH>무게</TH>
                                <TD>
                                    <input TYPE="checkbox" name="weight" value = "underone">1kg 이하&nbsp&nbsp&nbsp&nbsp
                                    <input TYPE="checkbox" name="weight" value = "onetotwo">1kg~2kg&nbsp&nbsp&nbsp&nbsp
                                    <input TYPE="checkbox" name="weight" value = "overtwo">2kg 이상&nbsp&nbsp&nbsp&nbsp
                                </TD>
                            </tr>
                        </table>
                        <div class="dropdown">
                            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                정렬순서
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" href="?sort=price,asc">낮은 가격순</a>
                                <a class="dropdown-item" href="?sort=price,desc">높은 가격순</a>
                                <a class="dropdown-item" href="?sort=weight,asc">낮은 무게순</a>
                            </div>
                            <button type="button" class="btn btn-danger float-right">조건검색</button>
                        </div>
                    </form>
                </div> <!-- 테이블 -->

                <!-- 카드 이미지 -->
                <c:forEach var="notebook" items="${notebookPage.content}">
                    <div class="col-lg-4 col-md-6 mb-4">
                        <div class="card h-100">
                            <a href="http://comalmot.com/notebookinfo/${notebook.id}"><img class="card-img-top" src=${notebook.imgurlf} alt=""></a>
                            <div class="card-body">
                                <h5 class="card-title ">
                                    <a href="http://comalmot.com/notebookinfo/${notebook.id}" >${notebook.model}</a>
                                </h5>
                                <h5>${notebook.pricestring} 원</h5>
                                <p class="card-text">
                                        ${notebook.cpumanufact} / ${notebook.cpukind} / RAM ${notebook.memorysize} GB / ${notebook.sizeint}인치
                                </p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
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
<script src="/webjars/bootstrap/4.2.1/js/bootstrap.bundle.js"></script>
<script type="text/javascript">
    $(function () {
        console.log("jQuery ready");
    });
</script>

</body>

</html>
