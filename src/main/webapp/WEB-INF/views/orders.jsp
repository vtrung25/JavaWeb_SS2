<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sach don hang</title>
</head>
<body>
<c:set var="pageTitle" value="Danh sach don hang" scope="page" />
<h2>${pageScope.pageTitle}</h2>

<p>
    Xin chao, <strong><c:out value="${sessionScope.loggedUser}" /></strong>!
    Vai tro: <strong><c:out value="${sessionScope.role}" /></strong>
</p>

<fmt:setLocale value="vi_VN" />

<table border="1" cellpadding="6" cellspacing="0">
    <thead>
    <tr>
        <th>Ma don</th>
        <th>San pham</th>
        <th>Tong tien</th>
        <th>Ngay dat</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.orders}" var="order">
        <tr>
            <td><c:out value="${order.orderCode}" /></td>
            <td><c:out value="${order.productName}" /></td>
            <td>
                <fmt:formatNumber value="${order.totalAmount}" type="currency" currencySymbol="VND " />
            </td>
            <td><fmt:formatDate value="${order.orderDate}" pattern="dd/MM/yyyy" /></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<p>Tong luot xem don hang toan he thong: <strong>${applicationScope.totalViewCount}</strong></p>
<p><a href="${pageContext.request.contextPath}/logout">Dang xuat</a></p>
</body>
</html>



