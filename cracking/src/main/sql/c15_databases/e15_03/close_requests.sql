update Requests
    set Status = 'Closed'
    where AptID in
    (select AptID from Apartments where BuildingID = 10);

select * from Requests;
