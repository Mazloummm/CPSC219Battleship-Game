A=c(8,10,6,10,7,8,4,9,8,20)
B=c(7,1,4,10,4,3,6,2,4,25)

wilcox.test(A,B,alternative = "greater",mu = 0,paired = T,exact = F)

#library(nortest)
#ad.test(A)
#ad.test(B)
ad.test(A-B)

t.test(A,B,alternative = "greater",mu = 0,paired = T)


#########################
#shoe1 <- read.csv("~/Desktop/shoe1.csv")
#
#ad.test(shoe1$ShoeA)
#ad.test(shoe1$ShoeB)
ad.test(shoe1$ShoeA-shoe1$ShoeB)


wilcox.test(shoe1$ShoeA,shoe1$ShoeB,alternative = "two.sided",mu = 0,paired = T,exact = F,conf.int = T)


############
#coffee <- read.csv("~/Desktop/coffee.csv")

#ad.test(coffee$starbuck)
#ad.test(coffee$secondcup)
ad.test(coffee$starbuck-coffee$secondcup)

wilcox.test(coffee$starbuck,coffee$secondcup,alternative = "greater",mu = 300,paired = T,exact = F,conf.int = T,conf.level = .90)


