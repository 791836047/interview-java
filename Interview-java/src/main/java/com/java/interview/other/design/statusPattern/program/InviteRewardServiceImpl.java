package com.java.interview.other.design.statusPattern.program;

/**
 * 流程图 https://tech.meituan.com/2020/03/19/design-pattern-practice-in-marketing.html
 * @author liaowenhui
 * @date 2023/7/27 15:23
 */
public class InviteRewardServiceImpl {

    public static void main(String[] args) {
        InviteRewardServiceImpl a = new InviteRewardServiceImpl();
        a.sendRewardForInvtee(123456L,20231314L);
    }

    public boolean sendRewardForInvtee(long userId, long orderId) {
        Request request = new Request(userId, orderId);
        RewardStateContext rewardContext = new RewardStateContext();
        rewardContext.setRewardState(new OrderCheckState());
        //开始返奖，订单校验
        System.out.println("开始返奖 -> 待校验状态");
        rewardContext.echo(rewardContext, request);
        //此处的if-else逻辑只是为了表达状态的转换过程，并非实际的业务逻辑

        //如果订单校验成功，进入预返奖状态
        if (rewardContext.isResultFlag()) {
            System.out.println("待校验成功 -> 预返奖状态");
            rewardContext.setRewardState(new BeforeRewardCheckState());
            rewardContext.echo(rewardContext, request);
        } else {
            System.out.println("待校验失败 -> 失败状态");

            //如果订单校验失败，进入返奖失败流程，...
            rewardContext.setRewardState(new RewardFailedState());
            rewardContext.echo(rewardContext, request);
            return false;
        }

        //预返奖检查成功，进入待返奖流程，...
        if (rewardContext.isResultFlag()) {
            System.out.println("预返奖成功 -> 待返奖状态");
            rewardContext.setRewardState(new SendRewardState());
            rewardContext.echo(rewardContext, request);
        } else {
            //预返奖检查失败，进入返奖失败流程，...
            System.out.println("预返奖失败 -> 失败状态");
            rewardContext.setRewardState(new RewardFailedState());
            rewardContext.echo(rewardContext, request);
            return false;
        }

        //返奖成功，进入返奖结束流程，...
        if (rewardContext.isResultFlag()) {
            System.out.println("待返奖成功 -> 完成");
            rewardContext.setRewardState(new RewardSuccessState());
            rewardContext.echo(rewardContext, request);
            System.out.println("返奖成功，结束");
            return true;
        } else {
            System.out.println("待返奖失败 -> 返奖补偿状态");
            rewardContext.setRewardState(new CompensateRewardState());
            rewardContext.echo(rewardContext, request);
        }

        //补偿成功，进入返奖完成阶段，...
        if (rewardContext.isResultFlag()) {
            System.out.println("补偿成功 -> 完成");
            rewardContext.setRewardState(new RewardSuccessState());
            rewardContext.echo(rewardContext, request);
            return true;
        } else {
            //补偿失败，仍然停留在当前态，直至补偿成功（或多次补偿失败后人工介入处理）
            rewardContext.setRewardState(new CompensateRewardState());
            rewardContext.echo(rewardContext, request);
        }
        System.out.println("补偿失败，结束");
        return false;
    }


}
