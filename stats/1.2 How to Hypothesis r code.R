#Problem 1: Two-Tailed Test for mu
df=50-1
t_cv1=qt(p = .025,df = df)
t_cv1
t_cv2=qt(.975,49)
t_cv2
t_ts=(295-300)/(20/50^.5)
t_ts
pvalue=min(2*pt(t_ts,df),2*pt(-1*t_ts,df))
pvalue

install.packages("BSDA")
library("BSDA")

tsum.test(mean.x = 295,s.x = 20,n.x = 50,alternative = "two.sided",mu = 300,conf.level = .95)

#Problem 2: One.tailed (less) test for mu
df=20-1
t_cv=qt(p = .01,df = df)
t_cv
t_ts=(108-110)/(10/20^.5)
t_ts
pvalue=pt(t_ts,df)
pvalue

tsum.test(mean.x = 108,s.x = 10,n.x = 20,alternative = "less",mu = 110,conf.level = .99)
options(digits=9)


#Problem 1: Two-Tailed Test for p
z_cv1=qnorm(p = .025)
z_cv1
p_cv1=qnorm(.025,.8,(.8*.2/100)^.5)
p_cv1

z_cv2=qnorm(.975)
z_cv2
p_cv2=qnorm(.975,.8,(.8*.2/100)^.5)
p_cv2

z_ts=(.73-.8)/(.8*.2/100)^.5
z_ts
pvalue=min(2*pnorm(z_ts),2*pnorm(-1*z_ts))
pvalue

prop.test(x = 73,n = 100,p = 0.8,alternative = "two.sided",conf.level = .95,correct = F)

#Problem 2: TOne-Tailed (less) Test for p
z_cv=qnorm(p = .05)
z_cv
p_cv=qnorm(.05,.8,(.8*.2/100)^.5)
p_cv

z_ts=(.73-.8)/(.8*.2/100)^.5
z_ts
pvalue=pnorm(z_ts)
pvalue

prop.test(x = 73,n = 100,p = 0.8,alternative = "less",conf.level = .95,correct = F)

#Example 11
data <- read.csv("~/Desktop/217 1.2/example 11.csv")
data$x
data$X

install.packages("nortest")
library("nortest")
ad.test(data$X)

tsum.test(mean.x = mean(data$X),s.x = sd(data$X),n.x = length(data$X),alternative = "less",mu = 13015,conf.level = .95)
t.test(x = data$X,alternative = "less",mu = 13015,conf.level = .95)

#Example 12
tsum.test(mean.x = 8.62,s.x = 3,n.x = 100,alternative = "two.sided",mu = 8)

#Example 13
prop.test(x = 126,n = 300,p = .45,alternative = "less",conf.level = .95,correct = F)

#Example 14
prop.test(x=0.46*400,n = 400,p = .5,alternative = "less",correct = F)
