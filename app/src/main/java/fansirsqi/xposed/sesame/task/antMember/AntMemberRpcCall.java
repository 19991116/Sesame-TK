package fansirsqi.xposed.sesame.task.antMember;

import org.json.JSONException;
import org.json.JSONObject;
import fansirsqi.xposed.sesame.entity.RpcEntity;
import fansirsqi.xposed.sesame.hook.RequestManager;
import fansirsqi.xposed.sesame.util.RandomUtil;

public class AntMemberRpcCall {

    private static String getUniqueId() {
        return String.valueOf(System.currentTimeMillis()) + RandomUtil.nextLong();
    }

    public static Boolean check() {
        boolean z = true;
        RpcEntity rpcEntity = RequestManager.requestObject("alipay.antmember.biz.rpc.member.h5.queryPointCert",
                "[{\"page\":" + 1 + ",\"pageSize\":" + 8 + "}]", 1, 0);
        if (rpcEntity == null || rpcEntity.getHasError()){
            z = false;
        }
        return z;
    }

    /* ant member point */
    public static String queryPointCert(int page, int pageSize) {
        String args1 = "[{\"page\":" + page + ",\"pageSize\":" + pageSize + "}]";
        return RequestManager.requestString("alipay.antmember.biz.rpc.member.h5.queryPointCert", args1);
    }

    public static String receivePointByUser(String certId) {
        String args1 = "[{\"certId\":" + certId + "}]";
        return RequestManager.requestString("alipay.antmember.biz.rpc.member.h5.receivePointByUser", args1);
    }

    public static String queryMemberSigninCalendar() {
        return RequestManager.requestString("com.alipay.amic.biz.rpc.signin.h5.queryMemberSigninCalendar",
                "[{\"autoSignIn\":true,\"invitorUserId\":\"\",\"sceneCode\":\"QUERY\"}]");
    }

    /* 商家服务 */
    public static String transcodeCheck() {
        return RequestManager.requestString("alipay.mrchservbase.mrchbusiness.sign.transcode.check",
                "[{}]");
    }

    public static String zcjSignInQuery() {
        return RequestManager.requestString("alipay.mrchservbase.zcj.view.invoke",
                "[{\"compId\":\"ZCJ_SIGN_IN_QUERY\"}]");
    }

    public static String zcjSignInExecute() {
        return RequestManager.requestString("alipay.mrchservbase.zcj.view.invoke",
                "[{\"compId\":\"ZCJ_SIGN_IN_EXECUTE\"}]");
    }

    public static String taskListQuery() {
        return RequestManager.requestString("alipay.mrchservbase.zcj.taskList.query",
                "[{\"compId\":\"ZCJ_TASK_LIST\",\"params\":{\"activityCode\":\"ZCJ\",\"clientVersion\":\"10.3.36\",\"extInfo\":{},\"platform\":\"Android\",\"underTakeTaskCode\":\"\"}}]");
    }

    public static String queryActivity() {
        return RequestManager.requestString("alipay.merchant.kmdk.query.activity",
                "[{\"scene\":\"activityCenter\"}]");
    }

    public static String signIn(String activityNo) {
        return RequestManager.requestString("alipay.merchant.kmdk.signIn",
                "[{\"activityNo\":\"" + activityNo + "\"}]");
    }

    public static String signUp(String activityNo) {
        return RequestManager.requestString("alipay.merchant.kmdk.signUp",
                "[{\"activityNo\":\"" + activityNo + "\"}]");
    }

    /* 商家服务任务 */

    public static String taskFinish(String bizId) {
        return RequestManager.requestString("com.alipay.adtask.biz.mobilegw.service.task.finish",
                "[{\"bizId\":\"" + bizId + "\"}]");
    }

    public static String taskReceive(String taskCode) {
        return RequestManager.requestString("alipay.mrchservbase.sqyj.task.receive",
                "[{\"compId\":\"ZTS_TASK_RECEIVE\",\"extInfo\":{\"taskCode\":\"" + taskCode + "\"}}]");
    }

    public static String actioncode(String actionCode) {
        return RequestManager.requestString("alipay.mrchservbase.task.query.by.actioncode",
                "[{\"actionCode\":\"" + actionCode + "\"}]");
    }

    public static String produce(String actionCode) {
        return RequestManager.requestString("alipay.mrchservbase.biz.task.action.produce",
                "[{\"actionCode\":\"" + actionCode + "\"}]");
    }

    public static String ballReceive(String ballIds) {
        return RequestManager.requestString("alipay.mrchservbase.mrchpoint.ball.receive",
                "[{\"ballIds\":[\"" + ballIds
                        + "\"],\"channel\":\"MRCH_SELF\",\"outBizNo\":\"" + getUniqueId() + "\"}]");
    }

    /* 会员任务 */
    public static String signPageTaskList() {
        return RequestManager.requestString("alipay.antmember.biz.rpc.membertask.h5.signPageTaskList",
                "[{\"sourceBusiness\":\"antmember\",\"spaceCode\":\"ant_member_xlight_task\"}]");
    }

    public static String applyTask(String darwinName, Long taskConfigId) {
        return RequestManager.requestString("alipay.antmember.biz.rpc.membertask.h5.applyTask",
                "[{\"darwinExpParams\":{\"darwinName\":\"" + darwinName
                        + "\"},\"sourcePassMap\":{\"innerSource\":\"\",\"source\":\"myTab\",\"unid\":\"\"},\"taskConfigId\":"
                        + taskConfigId + "}]");
    }

    public static String executeTask(String bizParam, String bizSubType) {
        return RequestManager.requestString("alipay.antmember.biz.rpc.membertask.h5.executeTask",
                "[{\"bizOutNo\":\"" + (System.currentTimeMillis() - 16000L) + "\",\"bizParam\":\""
                        + bizParam + "\",\"bizSubType\":\"" + bizSubType + "\",\"bizType\":\"BROWSE\"}]");
    }

    public static String queryAllStatusTaskList() {
        return RequestManager.requestString("alipay.antmember.biz.rpc.membertask.h5.signPageTaskList",
                "[{\"sourceBusiness\":\"signInAd\",\"sourcePassMap\":{\"innerSource\":\"\",\"source\":\"myTab\",\"unid\":\"\"}}]");
    }

    public static String rpcCall_signIn() {
        String args1 = "[{\"sceneCode\":\"KOUBEI_INTEGRAL\",\"source\":\"ALIPAY_TAB\",\"version\":\"2.0\"}]";
        return RequestManager.requestString("alipay.kbmemberprod.action.signIn", args1);
    }

    /**
     * 黄金票收取
     *
     * @param str signInfo
     * @return 结果
     */
    public static String goldBillCollect(String str) {
        return RequestManager.requestString("com.alipay.wealthgoldtwa.goldbill.v2.index.collect",
                "[{" + str + "\"trigger\":\"Y\"}]");
    }

    /**
     * 游戏中心签到查询
     */
    public static String querySignInBall() {
        return RequestManager.requestString("com.alipay.gamecenteruprod.biz.rpc.v3.querySignInBall",
                "[{\"source\":\"ch_appcenter__chsub_9patch\"}]");
    }

    /**
     * 游戏中心签到
     */
    public static String continueSignIn() {
        return RequestManager.requestString("com.alipay.gamecenteruprod.biz.rpc.continueSignIn",
                "[{\"sceneId\":\"GAME_CENTER\",\"signType\":\"NORMAL_SIGN\",\"source\":\"ch_appcenter__chsub_9patch\"}]");
    }

    /**
     * 游戏中心查询待领取乐豆列表
     */
    public static String queryPointBallList() {
        return RequestManager.requestString("com.alipay.gamecenteruprod.biz.rpc.v3.queryPointBallList",
                "[{\"source\":\"ch_appcenter__chsub_9patch\"}]");
    }

    /**
     * 游戏中心全部领取
     */
    public static String batchReceivePointBall() {
        return RequestManager.requestString("com.alipay.gamecenteruprod.biz.rpc.v3.batchReceivePointBall",
                "[{}]");
    }

    /**
     * 查询可收取的芝麻粒
     *
     * @return 结果
     */
    public static String queryCreditFeedback() {
        return RequestManager.requestString(
                "com.antgroup.zmxy.zmcustprod.biz.rpc.home.creditaccumulate.api.CreditAccumulateRpcManager.queryCreditFeedback",
                "[{\"queryPotential\":false,\"size\":20,\"status\":\"UNCLAIMED\"}]");
    }

    /**
     * 芝麻信用首页
     *
     * @return 结果
     */
    public static String queryHome() {
        return RequestManager.requestString("com.antgroup.zmxy.zmcustprod.biz.rpc.home.api.HomeV6RpcManager.queryHome",
                "[{\"miniZmGrayInside\":\"\"}]");
    }

    /**
     * 收取芝麻粒
     *
     * @param creditFeedbackId creditFeedbackId
     * @return 结果
     */
    public static String collectCreditFeedback(String creditFeedbackId) {
        return RequestManager.requestString(
                "com.antgroup.zmxy.zmcustprod.biz.rpc.home.creditaccumulate.api.CreditAccumulateRpcManager.collectCreditFeedback",
                "[{\"collectAll\":false,\"creditFeedbackId\":\"" + creditFeedbackId + "\",\"status\":\"UNCLAIMED\"}]");
    }

    /**
     * 查询生活记录
     *
     * @return 结果
     */
    public static String promiseQueryHome() {
        return RequestManager.requestString("com.antgroup.zmxy.zmmemberop.biz.rpc.promise.PromiseRpcManager.queryHome", null);
    }

    /**
     * 查询生活记录明细
     *
     * @param recordId recordId
     * @return 结果
     */
    public static String promiseQueryDetail(String recordId) {
        return RequestManager.requestString("com.antgroup.zmxy.zmmemberop.biz.rpc.promise.PromiseRpcManager.queryDetail",
                "[{\"recordId\":\"" + recordId + "\"}]");
    }

    /**
     * 生活记录加入新纪录
     *
     * @param data data
     * @return 结果
     */
    public static String promiseJoin(String data) {
        return RequestManager.requestString("com.antgroup.zmxy.zmmemberop.biz.rpc.promise.PromiseRpcManager.join",
                "[" + data + "]");
    }

    /**
     * 查询待领取的保障金
     *
     * @return 结果
     */
    public static String queryMultiSceneWaitToGainList() {
        return RequestManager.requestString("com.alipay.insgiftbff.insgiftMain.queryMultiSceneWaitToGainList",
                "[{\"entrance\":\"jkj_zhima_dairy66\",\"eventToWaitParamDTO\":{\"giftProdCode\":\"GIFT_UNIVERSAL_COVERAGE\"," +
                        "\"rightNoList\":[\"UNIVERSAL_ACCIDENT\",\"UNIVERSAL_HOSPITAL\",\"UNIVERSAL_OUTPATIENT\"," +
                        "\"UNIVERSAL_SERIOUSNESS\",\"UNIVERSAL_WEALTH\",\"UNIVERSAL_TRANS\",\"UNIVERSAL_FRAUD_LIABILITY\"]}," +
                        "\"helpChildParamDTO\":{\"giftProdCode\":\"GIFT_HEALTH_GOLD_CHILD\",\"rightNoList\":[\"UNIVERSAL_ACCIDENT\"," +
                        "\"UNIVERSAL_HOSPITAL\",\"UNIVERSAL_OUTPATIENT\",\"UNIVERSAL_SERIOUSNESS\",\"UNIVERSAL_WEALTH\"," +
                        "\"UNIVERSAL_TRANS\",\"UNIVERSAL_FRAUD_LIABILITY\"]},\"priorityChannelParamDTO\":{\"giftProdCode\":" +
                        "\"GIFT_UNIVERSAL_COVERAGE\",\"rightNoList\":[\"UNIVERSAL_ACCIDENT\",\"UNIVERSAL_HOSPITAL\"," +
                        "\"UNIVERSAL_OUTPATIENT\",\"UNIVERSAL_SERIOUSNESS\",\"UNIVERSAL_WEALTH\",\"UNIVERSAL_TRANS\"," +
                        "\"UNIVERSAL_FRAUD_LIABILITY\"]},\"signInParamDTO\":{\"giftProdCode\":\"GIFT_UNIVERSAL_COVERAGE\"," +
                        "\"rightNoList\":[\"UNIVERSAL_ACCIDENT\",\"UNIVERSAL_HOSPITAL\",\"UNIVERSAL_OUTPATIENT\"," +
                        "\"UNIVERSAL_SERIOUSNESS\",\"UNIVERSAL_WEALTH\",\"UNIVERSAL_TRANS\",\"UNIVERSAL_FRAUD_LIABILITY\"]}}]");
    }

    /**
     * 领取保障金
     *
     * @param jsonObject jsonObject
     * @return 结果
     */
    public static String gainMyAndFamilySumInsured(JSONObject jsonObject) throws JSONException {
        jsonObject.put("disabled", false);
        jsonObject.put("entrance", "jkj_zhima_dairy66");
        return RequestManager.requestString("com.alipay.insgiftbff.insgiftMain.gainMyAndFamilySumInsured",
                "[" + jsonObject + "]");
    }

    // 安心豆
    public static String querySignInProcess(String appletId, String scene) {
        return RequestManager.requestString("com.alipay.insmarketingbff.bean.querySignInProcess",
                "[{\"appletId\":\"" + appletId + "\",\"scene\":\"" + scene + "\"}]");
    }

    public static String signInTrigger(String appletId, String scene) {
        return RequestManager.requestString("com.alipay.insmarketingbff.bean.signInTrigger",
                "[{\"appletId\":\"" + appletId + "\",\"scene\":\"" + scene + "\"}]");
    }

    public static String beanExchangeDetail(String itemId) {
        return RequestManager.requestString("com.alipay.insmarketingbff.onestop.planTrigger",
                "[{\"extParams\":{\"itemId\":\"" + itemId + "\"},"
                        + "\"planCode\":\"bluebean_onestop\",\"planOperateCode\":\"exchangeDetail\"}]");
    }

    public static String beanExchange(String itemId, int pointAmount) {
        return RequestManager.requestString("com.alipay.insmarketingbff.onestop.planTrigger",
                "[{\"extParams\":{\"itemId\":\"" + itemId + "\",\"pointAmount\":\"" + Integer.toString(pointAmount) + "\"},"
                        + "\"planCode\":\"bluebean_onestop\",\"planOperateCode\":\"exchange\"}]");
    }

    public static String queryUserAccountInfo(String pointProdCode) {
        return RequestManager.requestString("com.alipay.insmarketingbff.point.queryUserAccountInfo",
                "[{\"channel\":\"HiChat\",\"pointProdCode\":\"" + pointProdCode + "\",\"pointUnitType\":\"COUNT\"}]");
    }
}
