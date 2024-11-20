

McDonald_s=c(49,49,49,48,49)
Wendy_s=c(49,55,50,42,NA) # all vectors must be of the same length 
Subway=c(51,46,73,52,35)
Tim_Horton_s=c(53,52,41,60,59)
Opa=c(45,35,47,NA,NA)


data=data.frame(McDonald_s,Wendy_s,Subway,Tim_Horton_s,Opa)


st1=stack(data)
st1
st2=na.omit(st1)
st2

mean(st2$values)
sd(st2$values)


boxplot(st2$values~st2$ind,horizontal = T)

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

my.anova=aov(values~ind,data = st2)
my.anova
summary(my.anova)

options(digits=12)
summary(my.anova)

library(car)
leveneTest(st2$values,st2$ind,)
library(nortest)
ad.test(McDonald_s)
ad.test(Wendy_s)
ad.test(Subway)
ad.test(Tim_Horton_s)
ad.test(Opa)


options(digits=8)
TukeyHSD(my.anova,conf.level = 0.95)
plot(TukeyHSD(my.anova,conf.level = 0.95))


#########################################################3

Compact_cars=c(643,655,702)
Midsize_cars=c(469,427,525)
Fullsize_cars=c(484,456,402)
data=data.frame(Compact_cars,Midsize_cars,Fullsize_cars)

#copy paste old code?

st1=stack(data)
st1
st2=na.omit(st1)
st2
options(digits=22)
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

my.anova=aov(values~ind,data = st1)
my.anova
summary(my.anova)

options(digits=12)
summary(my.anova)

library(car)
leveneTest(st2$values,st2$ind,)

library(nortest)
ad.test(Compact_cars)
ad.test(Midsize_cars)
ad.test(Fullsize_cars)

options(digits=8)
TukeyHSD(my.anova,conf.level = 0.95)
plot(TukeyHSD(my.anova,conf.level = 0.95))

qtukey(.95,4,18)
