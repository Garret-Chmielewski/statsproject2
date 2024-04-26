minrange= 0;
maxrange= 5000;

filecreate = fopen("plottingMAT.csv","w");

xvalues = (minrange:maxrange +1);
y = (xvalues.^2)+2*xvalues+1;

setA = horzcat(xvalues,y);
fprintf(filecreate, '%s,%s\n', 'X','Y');

fprintf(filecreate, '%f,%f\n',setA);
plot(xvalues,y);
set(gca, linewidth=1, fontsize=14);
xlabel("x");
ylabel("y");

title("Plotting MATLAB");
grid on

fclose(filecreate);