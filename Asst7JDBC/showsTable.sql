create table shows (
    id number(9) primary key,
    movie_id number(9) REFERENCES movies(id),
    time Date,
    totalSeats number(9),
    availableSeats number(9),
    constraint seatAvailability CHECK (availableSeats <= totalSeats and availableSeats >= 0)
);