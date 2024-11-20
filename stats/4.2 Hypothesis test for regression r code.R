#reg1 <- read.csv("~/Desktop/reg1.csv")

cor(reg1$x,reg1$y)
cor(reg1$x,reg1$y)^2
plot(reg1$x,reg1$y)
fit=lm(reg1$y~reg1$x)
abline(fit)
fit 
summary (fit)
plot(fit)
confint(fit,level=.92)
confint(fit,level=.95)
anova(fit)

2*(1-pt(.878,3))

qt(.025,3)

