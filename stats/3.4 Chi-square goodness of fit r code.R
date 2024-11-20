cards=c(50,45,5)
chisq.test(cards,p=c(.3,.6,.1),correct=F)


##########
eye_col=c(60, 45,10, 7, 28)
test=chisq.test(eye_col,p=c(1/5,1/5,1/5,1/5,1/5),correct=F)
test$observed
test$expected



test1=chisq.test(eye_col,p=c(.55,.08,.02,.05,.3),correct=F)
test1
test1$observed
test1$expected

eye_col1=c(60, 45, 7, 28+10)

test2=chisq.test(eye_col1,p=c(.55,.08,.05,.3+.02),correct=F)
test2
test2$observed
test2$expected


######