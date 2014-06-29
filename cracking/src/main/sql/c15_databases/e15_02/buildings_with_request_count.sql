/*
select *
from Buildings
    left join Apartments on Buildings.BuildingID = Apartments.BuildingID
    left join Requests on Requests.AptID = Apartments.AptID
    where Requests.Status = 'Open';
*/

select Buildings.BuildingID, BuildingName, RequestCounts.Count
from Buildings
    left join
        (select Apartments.BuildingID, count(*) as Count
            from Apartments
            inner join Requests on Requests.AptID = Apartments.AptID
            where Requests.Status = 'Open'
            group by Apartments.BuildingID) RequestCounts
        on  Buildings.BuildingID = RequestCounts.BuildingID;
