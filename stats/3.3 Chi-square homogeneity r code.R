gender=c(rep("Boys",100),rep("Girls",200))
viewing=c(rep("The Lone Ranger",50),rep("Sesame Street",30),rep("The Simpsons",20),rep("The Lone Ranger",50),rep("Sesame Street",80),rep("The Simpsons",70))
df=data.frame(gender,viewing)
table(df)

chisq.test(table(df),correct=F)

#or

df=matrix(c(50,30,20,50,80,70),ncol = 3,byrow = T)
colnames(df)=c("The Lone Ranger","Sesame Street","The Simpsons")
rownames(df)=c("Boys","Girls")
df


chisq.test(df,correct=F)
test=chisq.test(df,correct=F)
test$observed
test$expected
(test$observed-test$expected)^2/test$expected
sum((test$observed-test$expected)^2/test$expected)
  
  