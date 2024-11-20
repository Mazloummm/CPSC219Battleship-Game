#IQ <- read.csv("~/Desktop/IQ.csv")
#library(nortest)
diff=IQ$training-IQ$no_training
ad.test(diff)

t.test(diff,alternative = "two.sided",mu = 0)
t.test(x = IQ$training,y = IQ$no_training,alternative = "two.sided",mu = 0,paired = T,conf.level = 0.95)


########################

#plates1 <- read.csv("~/Desktop/plates1.csv")

dif1=plates1$after-plates1$before
dif2=plates1$before-plates1$after
ad.test(dif1)
ad.test(dif2)

t.test(dif1,alternative = "greater")
t.test(dif2,alternative = "less")

t.test(x = plates1$after,y = plates1$before,alternative = "greater",paired = T)
