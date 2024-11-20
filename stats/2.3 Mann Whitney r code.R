library(nortest)
Random.Distribution.Data <- read.csv("/Users/danilipman/Desktop/STAT 217/Code Files/Random Distribution Data.csv")
rpois(n = 12,lambda = 5)

ad.test(Random.Distribution.Data$Poisson)
ad.test(Random.Distribution.Data$Exponential)
ad.test(Random.Distribution.Data$Hyper.Geometric)
ad.test(Random.Distribution.Data$Normal)

########################
small.MW.set.stacked <- read.csv("/Users/danilipman/Desktop/STAT 217/Code Files/small MW set stacked.csv")
small.MW.set.stacked
rank(small.MW.set.stacked$value)

df=unstack(small.MW.set.stacked,)
df


wilcox.test(x = df$A,y = df$B,alternative = "two.sided",mu = 0,paired = F,exact = F,correct = T,conf.int = T,conf.level = 0.95)

wilcox.test(small.MW.set.stacked$value~small.MW.set.stacked$ind,paired = F,exact = F)

MW = read.csv("/Users/danilipman/Desktop/STAT 217/Code Files/MW.csv")
MW

wilcox.test(MW$a,MW$b,exact = F)

wilcox.test(MW$b,MW$a,exact=F)

###############################


time=c(9.79,9.8,9.88,9.63,9.75,9.94,9.98,11.99)
country=c(rep("USA",3),rep("Non USA",5))
time
country
data=data.frame(time,country)
data
rank(data$time)

a=unstack(data)
median(a$`Non USA`)
median(a$USA)

options(digits=10)
wilcox.test(x = a$USA,y = a$`Non USA`,alternative = "less",paired = F,exact = F,mu = 0)
wilcox.test(x = a$USA,y = a$`Non USA`,alternative = "greater",paired = F,exact = F,mu = 0)

wilcox.test(x = a$`Non USA`,y = a$USA,alternative = "greater",paired = F,exact = F,mu = 0)


#######################
No_weeds=c(166.7,172.2,165.0,176.9)
weeds=c(158.6,176.4,153.1,156.0)

wilcox.test(No_weeds,weeds,alternative = "greater",exact = F,paired = F)
