--SELECT Tenants.TenantName, T.cnt FROM
--    (SELECT TenantID, COUNT(AptID) as cnt
--    FROM AptTenants
--    GROUP BY TenantID) T INNER JOIN Tenants on T.TenantID = Tenants.TenantID
--WHERE cnt > 1;

--SELECT Tenants.TenantName, T.cnt FROM
--    (SELECT TenantID, count(*) as cnt
--    FROM AptTenants
--    GROUP BY TenantID
--    HAVING count(*) > 1) T
--    INNER JOIN Tenants on T.TenantID = Tenants.TenantID;

SELECT MAX(Tenants.TenantName), COUNT(*)
FROM Tenants INNER JOIN AptTenants USING(TenantID)
GROUP BY Tenants.TenantID
HAVING COUNT(*) > 1;