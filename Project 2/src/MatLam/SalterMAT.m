close all

filecreate = fopen("plottingMAT.csv","r");

label =fscanf(filecreate,'%s,%s',[2 1]);
firstset =fscanf(filecreate, '%f,%f',[2,maxrange] );
firstset = firstset';

Min= 2500;

Max =7500;

for j = 1:1: maxrange
    salt= randi([Min,Max]);
    holder= firstset(j,2);
    firstset(j,2) = holder + salt;
end

xvalues = firstset(:,1);
y= firstset(:,2);

fprintf(filecreate, '%f,%f\n', firstset');
plot(xvalues,y);
set(gca,linewidth=1, fontsize=14);
xlabel("x");
ylabel("y");

grid on

filecreate2=fopen("SalterMAT.csv","w");

fprintf(filecreate2, '%s,%s\n','x','y');
fprintf(filecreate2, '%f,%f\n', firstset');

fclose(filecreate);
fclose(filecreate2);
