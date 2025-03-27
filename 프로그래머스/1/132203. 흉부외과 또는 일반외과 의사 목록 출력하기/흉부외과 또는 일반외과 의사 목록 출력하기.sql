SELECT `DR_NAME`, `DR_ID`, `MCDP_CD`, DATE_FORMAT(`HIRE_YMD`, '%Y-%m-%d') AS 'HIRE_YMD' FROM `DOCTOR`
WHERE mcdp_cd IN ('CS', 'GS')
ORDER BY hire_ymd DESC, dr_name ASC;