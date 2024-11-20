

dafr1=data.frame(DATA=c(106,110),SEED=rep("Seed A-402",2),FERT=rep("Fert I",2));
dafr2=data.frame(DATA=c(95,100),SEED=rep("Seed A-402",2),FERT=rep("Fert II",2));
dafr3=data.frame(DATA=c(94,107),SEED=rep("Seed A-402",2),FERT=rep("Fert III",2));
dafr4=data.frame(DATA=c(103,104),SEED=rep("Seed A-402",2),FERT=rep("Fert IV",2));
dafr5=data.frame(DATA=c(100,102),SEED=rep("Seed A-402",2),FERT=rep("Fert V",2));

dafr6=data.frame(DATA=c(110,112),SEED=rep("Seed B-894",2),FERT=rep("Fert I",2));
dafr7=data.frame(DATA=c(98,99),SEED=rep("Seed B-894",2),FERT=rep("Fert II",2));
dafr8=data.frame(DATA=c(100,101),SEED=rep("Seed B-894",2),FERT=rep("Fert III",2));
dafr9=data.frame(DATA=c(108,112),SEED=rep("Seed B-894",2),FERT=rep("Fert IV",2));
dafr10=data.frame(DATA=c(105,107),SEED=rep("Seed B-894",2),FERT=rep("Fert V",2));

dafr11=data.frame(DATA=c(94,97),SEED=rep("Seed C-952",2),FERT=rep("Fert I",2));
dafr12=data.frame(DATA=c(86,87),SEED=rep("Seed C-952",2),FERT=rep("Fert II",2));
dafr13=data.frame(DATA=c(98,99),SEED=rep("Seed C-952",2),FERT=rep("Fert III",2));
dafr14=data.frame(DATA=c(99,101),SEED=rep("Seed C-952",2),FERT=rep("Fert IV",2));
dafr15=data.frame(DATA=c(94,98),SEED=rep("Seed C-952",2),FERT=rep("Fert V",2));


dafr=rbind(dafr1,dafr2,dafr3,dafr4,dafr5,dafr6,dafr7,dafr8,dafr9,dafr10,dafr11,dafr12,dafr13,dafr14,dafr15)
dafr

model=aov(DATA~SEED*FERT,data=dafr)
summary(model)

my.anova=aov(DATA~FERT,data=dafr)
TukeyHSD(my.anova,conf.level = 0.95)
plot(TukeyHSD(my.anova,conf.level = 0.95))

my.anova=aov(DATA~SEED,data=dafr)
TukeyHSD(my.anova,conf.level = 0.95)
plot(TukeyHSD(my.anova,conf.level = 0.95))

library(ggplot2)
ggplot(dafr, aes(fill=SEED, y=DATA, x=FERT))+geom_bar(position="dodge", stat="identity")
ggplot(dafr, aes(fill=FERT, y=DATA, x=SEED))+geom_bar(position="dodge", stat="identity")

xtabs(dafr)
xtabs(dafr)/2


interaction.plot(x.factor = dafr$FERT,trace.factor = dafr$SEED,response = dafr$DATA,type = "b",pch=20:25,col=rainbow(3));

interaction.plot(x.factor = dafr$SEED,trace.factor = dafr$FERT,response = dafr$DATA,type = "b",pch=20:25,col=rainbow(5));




########

dafr1=data.frame(DATA=c(9000,6000,7500,3000),AGE=rep("< 25",4),REWARD=rep("CASH",4));
dafr2=data.frame(DATA=c(0,2500,2500,2500),AGE=rep("< 25",4),REWARD=rep("Gift",4));
dafr3=data.frame(DATA=c(0,0,0,2500),AGE=rep("< 25",4),REWARD=rep("Credit",4));

dafr4=data.frame(DATA=c(1500,0,6000,4500),AGE=rep("25-36",4),REWARD=rep("CASH",4));
dafr5=data.frame(DATA=c(0,0,2500,2500),AGE=rep("25-36",4),REWARD=rep("Gift",4));
dafr6=data.frame(DATA=c(7500,10000,0,2500),AGE=rep("25-36",4),REWARD=rep("Credit",4));

dafr7=data.frame(DATA=c(3000,1500,1500,6000),AGE=rep("36-51",4),REWARD=rep("CASH",4));
dafr8=data.frame(DATA=c(0,0,5000,0),AGE=rep("36-51",4),REWARD=rep("Gift",4));
dafr9=data.frame(DATA=c(5000,7500,2500,2500),AGE=rep("36-51",4),REWARD=rep("Credit",4));

dafr10=data.frame(DATA=c(0,0,1500,0),AGE=rep("51-66",4),REWARD=rep("CASH",4));
dafr11=data.frame(DATA=c(0,2500,2500,5000),AGE=rep("51-66",4),REWARD=rep("Gift",4));
dafr12=data.frame(DATA=c(10000,7500,7500,5000),AGE=rep("51-66",4),REWARD=rep("Credit",4));

dafr13=data.frame(DATA=c(1500,1500,4500,4500),AGE=rep(">=66",4),REWARD=rep("CASH",4));
dafr14=data.frame(DATA=c(2500,5000,2500,2500),AGE=rep(">=66",4),REWARD=rep("Gift",4));
dafr15=data.frame(DATA=c(5000,2500,2500,2500),AGE=rep(">=66",4),REWARD=rep("Credit",4));

dafr=rbind(dafr1,dafr2,dafr3,dafr4,dafr5,dafr6,dafr7,dafr8,dafr9,dafr10,dafr11,dafr12,dafr13,dafr14,dafr15)

dafr

xtabs(dafr)/5

model=aov(DATA~AGE*REWARD,data=dafr)
summary(model)

interaction.plot(x.factor = dafr$AGE,trace.factor = dafr$REWARD,response = dafr$DATA,type = "b",pch=20:25,col=rainbow(3));

interaction.plot(x.factor = dafr$REWARD,trace.factor = dafr$AGE,response = dafr$DATA,type = "b",pch=20:25,col=rainbow(5));



