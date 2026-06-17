#SANCGA(The south African Nationl Computer Gamers Association) System

SANCGA (The South African National Computer
Gamers Association) is hosting a gaming competition
in 2025. Both professional as well as amateur gamers
can register to take part in the competition. A profes
sional gamer is defined as a person who is a member
of SANCGA and appears on the professional player’s
ranking list. On registration the gamers need to pro
vide their status, ID-number and name.
Status is either amateur or professional. Amateur
gamers are divided into three categories, viz. learner
(school), student (university or college) and adult.
Professional gamers also need to provide their rank
and the number of years that they have been regis
tered with SANCGA.
ID-numbers are six digits, the date of birth of the
gamer, in the format yymmdd, that is, 2 digits for
the year, 2 digits for the month and 2 digits for the
day. You can assume that no gamer is older than 100
years, therefore if yy is less than 25 it implies the year
20yy and yy greater than or equal to 25 implies the
year 19yy. As the competition is taking place in the
year 2025, the age of a gamer is calculated as the dif
ference between 2025 and the year in which the gamer
was born.
A registration code must be generated for each gamer.
(Hint: A helper method may be used for this.)
The registration code for an amateur gamer consists
of the letter A, followed by a 4-digit number, a dash
character (-) and a digit indicating the category of the
gamer. The 4-digit number consists of the birth year
and month (yymm)ofthe gamer. The category codes
are 1 for a learner, 2 for a student and 3 for an adult.
The registration code for a professional gamer consists
of the letter P, followed by a 4-digit number, a dash
character and the number of years that the gamer has
been registered with SANCGA (2 digits). The 4-digit
number consists of the gamer’s rank (2 digits) and age
(2 digits).
All numbers need to have leading zeros if their length
is shorter than the specified length.
The registration fee for professional gamers is R500
with a discount of 5% for each year that the gamers
has been registered with SANCGA, up to a maximum
of 50%. Therefore professional gamers who have been
registered with SANCGA for longer than 10 years will
get a discount of R250.
The registration fee for amateur gamers is R250 with
a 20% discount for gamers aged 18 or younger.
