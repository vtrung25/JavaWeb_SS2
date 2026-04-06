<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sach nhan vien</title>
</head>
<body>
<%@ include file="common/header.jspf" %>

<h2>Danh sach nhan vien</h2>
<fmt:setLocale value="vi_VN" />

<table border="1" cellpadding="6" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th>STT</th>
        <th>Ma NV</th>
        <th>Ho ten</th>
        <th>Phong ban</th>
        <th>Luong</th>
        <th>Ngay vao lam</th>
        <th>Trang thai</th>
        <th>Thao tac</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employees}" var="emp" varStatus="st">
        <tr>
            <td>${st.count}</td>
            <td><c:out value="${emp.code}" /></td>
            <td><c:out value="${emp.fullName}" /></td>
            <td><c:out value="${emp.department}" /></td>
            <td><fmt:formatNumber value="${emp.salary}" type="currency" currencySymbol="VND " /></td>
            <td><fmt:formatDate value="${emp.joinDate}" pattern="dd/MM/yyyy" /></td>
            <td>
                <c:choose>
                    <c:when test="${emp.status == 'Dang lam'}">
                        <span style="background: #2e7d32; color: white; padding: 2px 8px;">Dang lam</span>
                    </c:when>
                    <c:when test="${emp.status == 'Nghi phep'}">
                        <span style="background: #ef6c00; color: white; padding: 2px 8px;">Nghi phep</span>
                    </c:when>
                    <c:otherwise>
                        <span style="background: #1565c0; color: white; padding: 2px 8px;">Thu viec</span>
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <a href="<c:url value='/employees/${emp.code}' />">Xem chi tiet</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<p>
    Tong luong phong ban Ky thuat:
    <strong><fmt:formatNumber value="${technicalSalaryTotal}" type="currency" currencySymbol="VND " /></strong>
</p>

<%@ include file="common/footer.jspf" %>
</body>
</html>

