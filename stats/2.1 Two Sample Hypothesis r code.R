#Problem 1 (unequal variance)

tts=(78-85)/(10^2/30+15^2/25)^.5
df=(10^2/30+15^2/25)^2/((1/29)*(10^2/30)^2+(1/24)*(15^2/25)^2)
#a function to always calculate the df for the non-pooled two sample t test
df_nonpool=function(s1,s2,n1,n2){(s1^2/n1+s2^2/n2)^2/((1/(n1-1))*(s1^2/n1)^2+(1/(n2-1))*(s2^2/n2)^2)}
df_nonpool(10,15,30,25)
#critical values
qt(0.05,df)
qt(.95,df)
#p-value calculation
2*pt(-abs(tts),df)
-abs(tts)


#Or we can do a much nicer way using an R package... back to the BSDA package.
options(digits=10)
library(BSDA)
tsum.test(mean.x = 78,s.x = 10,n.x = 30,mean.y = 85,s.y = 15,n.y = 25,alternative = "two.sided",mu = 0,var.equal =FALSE,conf.level =.9  )
#####################

#Problem 2 (unequal variance)

#test stat
tts=(200-190-7)/(40^2/100+20^2/100)^.5
#find the degrees of freedom using the function from earlier
df = df_nonpool(20,40,100,100)
#p-value
pt(tts,df)

#critical value in case we want it
qt(.05,df)
library(BSDA)
tsum.test(mean.x = 200,s.x = 40,n.x = 100,mean.y = 190,s.y = 20,n.y = 100,alternative = "less",mu = 7,var.equal =FALSE,conf.level =.95  )
#####################
#Pooled sample variance 
#problem 1

#Function to find Sp
pool_sd=function(s1,n1,s2,n2){(((n1-1)*s1^2+(n2-1)*s2^2)/(n1+n2-2))^.5}
pool_sd(2,9,3,10)

#calculate test statistic
tts=(11-12)/(pool_sd(2,9,3,10)^2*(1/9+1/10))^.5
#function to find df
df_pool=function(n1,n2){n1+n2-2}
df_pool(9,10)

#critical values
qt(0.025,17)
qt(.975,17)
#p-value
2*pt(-abs(tts),17)

library(BSDA)
tsum.test(mean.x = 11,s.x = 2,n.x = 9,mean.y = 12,s.y = 3,n.y = 10,alternative = "two.sided",mu = 0,var.equal = T,conf.level = .95)
##########################


#Problem 2
library(BSDA)
tsum.test(mean.x = 17.4,s.x = 4.4752,n.x = 16,mean.y = 12.4,s.y = 4.8492,n.y = 9,alternative = "greater",mu = 0,var.equal = T,conf.level = .95)
