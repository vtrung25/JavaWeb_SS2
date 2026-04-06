<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tim kiem su kien</title>
</head>
<body>
<h2>Ket qua tim kiem cho: <c:out value="${keyword}" escapeXml="true" /></h2>
<p>Tim thay <c:out value="${fn:length(events)}" /> su kien</p>

<c:if test="${empty events}">
    <p>Khong tim thay su kien nao phu hop.</p>
</c:if>

<c:if test="${not empty events}">
    <table border="1" cellpadding="6" cellspacing="0">
        <thead>
        <tr>
            <th>STT</th>
            <th>Ten su kien</th>
            <th>Ngay to chuc</th>
            <th>Gia ve</th>
            <th>Ve con lai</th>
            <th>Thao tac</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${events}" var="event" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td><c:out value="${event.name}" escapeXml="true" /></td>
                <td><c:out value="${event.eventDate}" /></td>
                <td>
                    <c:choose>
                        <c:when test="${event.price == 0}">
                            <span>MIEN PHI</span>
                        </c:when>
                        <c:otherwise>
                            <fmt:formatNumber value="${event.price}" type="number" groupingUsed="true" /> VND
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${event.remainingTickets == 0}">
                            <span style="color: red;">HET VE</span>
                        </c:when>
                        <c:when test="${event.remainingTickets < 10}">
                            <span style="color: orange;">Sap het (con ${event.remainingTickets} ve)</span>
                        </c:when>
                        <c:otherwise>
                            <span style="color: green;"><c:out value="${event.remainingTickets}" /></span>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${event.remainingTickets == 0}">
                            <span style="color: gray;">Dat ve (disabled)</span>
                        </c:when>
                        <c:otherwise>
                            <c:url var="bookUrl" value="/events/${event.id}/book" />
                            <a href="${bookUrl}">Dat ve</a>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<c:if test="${not empty events}">
    <p>Su kien dau tien (IN HOA): <c:out value="${fn:toUpperCase(events[0].name)}" /></p>
</c:if>
<p>So ky tu cua tu khoa tim kiem: <c:out value="${fn:length(keyword)}" /> ky tu</p>

<form action="<c:url value='/events/search' />" method="get">
    <label>Tu khoa:</label>
    <input type="text" name="keyword" value="${fn:escapeXml(keyword)}" />
    <button type="submit">Tim kiem</button>
</form>
</body>
</html>


