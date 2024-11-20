x=c(95,85,80,70,60)
y=c(85,95,70,65,70)
cor(x,y)
cor(x,y)^2
plot(x,y)
fit=lm(y~x)
abline(fit)
fit 
summary(fit)

fit$residuals
fit$fitted.values

anova(fit)

plot(fit)
