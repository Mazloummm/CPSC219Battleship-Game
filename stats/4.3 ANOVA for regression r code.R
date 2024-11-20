x=c(95,85,80,70,60)
y=c(85,95,70,65,70)
reg1=data.frame(x,y)


cor(reg1$x,reg1$y)
cor(reg1$x,reg1$y)^2
plot(reg1$x,reg1$y)
fit=lm(reg1$y~reg1$x)

fit=lm(y~x, data=reg1)#better way to write it!

abline(fit)
fit
plot(fit)
confint(fit,level = .92)
confint(fit,level = .95)
anova(fit)



ciy=predict(fit,data.frame(x=81),se.fit=T,interval="confidence",level=.95)

piy=predict(fit,data.frame(x=81),se.fit=T,interval="prediction")
