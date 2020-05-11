SELECT
			*
FROM EMPLOYEES
    
<choose>
	<when test="key == 1">WHERE EMPLOYEE_ID = #{value}</when>
	<when test="key == 2">WHERE FIRST_NAME = #{value}</when>
	<when test="key == 3">WHERE DEPARTMENT_ID = #{value}</when>
</choose>
