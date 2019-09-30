<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Danh sách bài viết</title>
</head>

<body>
    <form action="<c:url value='/admin-new'/>" id="formSubmit" method="get">
        <div class="main-content">
            <div class="main-content-inner">
                <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                    <ul class="breadcrumb">
                        <li>
                            <i class="ace-icon fa fa-home home-icon"></i>
                            <a href="#">Trang chủ</a>
                        </li>
                    </ul><!-- /.breadcrumb -->
                </div>
                <div class="page-content">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="table-responsive">
                                        <table class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>Tên bài viết</th>
                                                    <th>Mô tả ngắn</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="item" items="${model.listResult}">
                                                    <tr>
                                                        <td>${item.title}</td>
                                                        <td>${item.shortDescription}</td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                        <ul class="pagination" id="pagination"></ul>
                                        <input type="hidden" value="" id="page" name="page"/>
                                        <input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <!-- /.main-content -->
    <script >
        var totalPages = ${model.totalPages};
        var currentPage = ${model.page};
        $(function () {
            window.pagObj = $('#pagination').twbsPagination({
                totalPages: totalPages,
                visiblePages: 2,
                startPage: currentPage,
                onPageClick: function (event, page) {
                	
                    $('#page').val(page);
                    $('formSubmit').submit();
                }
            });
        });
    </script>
</body>

</html>