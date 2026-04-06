<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Chi tiet nhan vien</title>
</head>
<body>
<%@ include file="common/header.jspf" %>

<h2>Chi tiet nhan vien</h2>
<fmt:setLocale value="vi_VN" />

<p>Ma NV: <strong><c:out value="${employee.code}" /></strong></p>
<p>Ho ten: <strong><c:out value="${employee.fullName}" /></strong></p>
<p>Phong ban: <strong><c:out value="${employee.department}" /></strong></p>
<p>Ngay vao lam: <strong><fmt:formatDate value="${employee.joinDate}" pattern="dd/MM/yyyy" /></strong></p>
<p>Trang thai: <strong><c:out value="${employee.status}" /></strong></p>
<p>
    Luong:
    <strong>
        <c:choose>
            <c:when test="${canViewSalary}">
                <fmt:formatNumber value="${employee.salary}" type="currency" currencySymbol="VND " />
            </c:when>
            <c:otherwise>
                ***
            </c:otherwise>
        </c:choose>
    </strong>
</p>

<p><a href="<c:url value='/employees' />">Quay lai</a></p>

<%@ include file="common/footer.jspf" %>
</body>
</html>

