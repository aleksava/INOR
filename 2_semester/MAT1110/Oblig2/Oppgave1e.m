%% Oppgave 1e) 
% Plotter grafen for antall biler i by A, B og C
n= (0:10)';
rn = 40*1.^n*[1 1 1] + 15*(0.3).^n*[0 1 -1] + 5*(0.1).^n*[-2 1 1];
plot(n,rn(:,1),n,rn(:,2),n,rn(:,3))
legend('A','B','C')