lab1=c(10,15,10,12,15)
lab2=c(14,18,19,15)
lab3=c(17,16,14,15,17,15,18)
lab4=c(12,15,17,15,16,15)
flammability=data.frame(lab1,lab2,lab3,lab4)#doesn't work

lab1=c(10,15,10,12,15,NA,NA)
lab2=c(14,18,19,15,NA,NA,NA)
lab3=c(17,16,14,15,17,15,18)
lab4=c(12,15,17,15,16,15,NA)
flammability=data.frame(lab1,lab2,lab3,lab4)

st1=stack(flammability)
st2=na.omit(st1)
st2

#or downloaded data
#flame <- read.csv("~/Desktop/flammability2.csv")

st2=flame[2:3]
st2

boxplot(st2$values~st2$ind)

library(dplyr)

group_by(st2, ind) %>%
  summarise(
    count = n(),
    mean = mean(values),
    sd = sd(values),
    sum=sum(values)
  )

library(ggpubr)

ggboxplot(st2, y = "values", x = "ind")

ggline(st2, y = "values", x = "ind", add = c("mean_se", "jitter"))

library(car)
leveneTest(st2$values,st2$ind,)
library(nortest)
ad.test(lab1)
ad.test(lab2)
ad.test(lab3)
ad.test(lab4)


my.anova=aov(values~ind,data = st2)
my.anova
summary(my.anova)

qtukey(.95,4,18)

ci=TukeyHSD(my.anova,conf.level = 0.95)
ci
plot(TukeyHSD(my.anova,conf.level = 0.95))
(ci$ind[,3]-ci$ind[,2])/2 #critical values for comparing differences


kruskal.test(values~ind,data = st2)
pairwise.wilcox.test(st2$values,st2$ind,p.adjust.method = "BH")

