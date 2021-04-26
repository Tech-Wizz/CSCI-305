%Kruize Christensen, Prolog Lab, March 15 2021

dorm([room(_, 5), room(_, 4), room(_, 3), room(_, 2), room(_, 1)]).
adjacent(X,Y) :- X =:= Y+1.
adjacent(X,Y) :- X =:= Y-1.

hallway(X) :- dorm(X),
	     member(room(hunter,A),X), A\=5,
 	     member(room(laura, B),X), B\=1,
	     member(room(arnie, C),X), C\=5, C\=1,  
             
	     \+(adjacent(C,B)),
	     
	     member(room(ramey, D),X), D > B, 	     
	     member(room(addiley, K),X),
	     
	     \+(adjacent(C,K)).
