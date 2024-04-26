close all

filecreate= fopen("SalterMAT.csv","r");

label =fscanf(filecreate,'%s,%s',[2 1]);
firstset =fscanf(filecreate, '%f,%f',[2,maxrange] );
firstset = firstset';

xvalues = firstset(:,1);
y= firstset(:,2);

holder= movmean(y,6000);
y= holder
firstset(:,2) =y;

fprintf(filecreate, '%f,%f\n', firstset');
plot(xvalues,y);
set(gca,linewidth=1, fontsize=14);
xlabel("x");
ylabel("y");

filecreate2 = fopen("SmootherMAT.csv","w")

fprintf(filecreate2, '%s,%s\n','x','y');
fprintf(filecreate2, '%f,%f\n', firstset');

fclose(filecreate);
fclose(filecreate2);


