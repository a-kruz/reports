<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" />
    <script src="${pageContext.request.contextPath}/js/moment.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/dateAutocomplete.js" type="text/javascript"></script>
    <title>Search Form</title>
</head>
<body>
    <div class="div">
        <s:form class="form" action="reports">
            <caption>Search Form</caption>
            <s:textfield class="field" name="startDate" id="start" label="Start Date" />
            <s:textfield class="field" name="endDate" id="end" label="End Date" />
            <s:select class="field" name="performer" list="performers" 
                      headerKey="" headerValue="All Performers" label="Performer" />
            <s:select class="field" name="timePeriod" id="tp" onchange="dateChange()" list="timePeriods"
                      headerKey="" headerValue=" " label="Time Period" />
            <s:submit class="submit"/>
        </s:form>
    
        <s:if test="%{!getErrorMessage().isEmpty()}">
            <div class="errors"><s:property value="errorMessage" /></div>
        </s:if>

        <s:if test="%{!getReportList().isEmpty()}">
            <table class="table">
                <caption>
                    Results Table
                </caption>
                <tr>
                    <th>Report Id</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Performer</th>
                    <th>Activity</th>
                </tr>
                <s:iterator value="reportList">
                    <tr>
                        <td><s:property value="id" /></td>
                        <td><s:property value="startDate" /></td>
                        <td><s:property value="endDate" /></td>
                        <td><s:property value="performer" /></td>
                        <td><s:property value="activity" /></td>
                    </tr>
                </s:iterator>
              </table>
        </s:if>
    </div>
    
</body>
</html>