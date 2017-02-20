%% Oppgave 2c)
% Bruker newtonfler lagt ut av foreleseren til å regne ut de 10 første 
% iterasjonene

x = newtonfler([1; 1],...
                @(x)[x(1)^2)*x(2)-(x(2)^2); X(1)-3],...
                @(x)[2*x(1)*x(2) x(1)^2-2*x(2); 1 0],0.0000001, 10)