library(car)

#option to read in the data from a csv file on your computer.
data = read.csv("/Users/danilipman/Desktop/STAT 217/Code Files/DataFiles/levene1.csv")
data
sd(data$pop1)

sd(data$pop2)

sd(data$pop2,na.rm = T)
sd(na.omit(data$pop2))


a=stack(data)
a
leveneTest(a$values~a$ind)

t.test(x = data$pop1,y = data$pop2,alternative = "two.sided",mu = 0,var.equal = T)

################

levene2 = read.csv("/Users/danilipman/Desktop/STAT 217/Code Files/DataFiles/levene2.csv")
library(nortest)

#lets take a look at the mean
mean(levene2$pop3,na.rm = T)
mean(levene2$pop4,na.rm = T)
#now lets take a look at the SD
sd(levene2$pop3,na.rm = T)
sd(levene2$pop4,na.rm = T)

#here I am just looking at the distributions of the data to see what the variances look like.
curve(dnorm(x,mean(levene2$pop4,na.rm = T),sd(levene2$pop4,na.rm = T)/41^.5),from = 5,to=20, col="hot pink")
curve(dnorm(x,mean(levene2$pop3,na.rm = T),sd(levene2$pop3,na.rm = T)/25^.5),from = 5,to=20, col="blue",add=T)

levene2 = read.csv("/Users/danilipman/Desktop/STAT 217/Code Files/DataFiles/levene2.csv")
library(nortest)
ad.test(levene2$pop3)
ad.test(levene2$pop4)

a=stack(levene2)

leveneTest(a$values~a$ind)
#leveneTest(a$ind~a$values)

#t-test when we have raw data rather than summary data
t.test(x = levene2$pop3,y = levene2$pop4,alternative = "two.sided",mu = 0,var.equal = F)
