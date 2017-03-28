package com.thit.hustar.util;

public class Random {
	public int count=(int)(Math.random()*100000);
	public int count2=(int)(Math.random()*100000);
	public int count3=(int)(Math.random()*100000);
	public int count4=(int)(Math.random()*100000);
	public int count5=(int)(Math.random()*100000);
	public String Partition_name="Partition_name"+count;
	/**
	 * 项目名称
	 */
	public String projectName="ProjectName"+count;
	/**
	 * 建筑名
	 */
	public String buildingName="BuildingName"+count;
	/**
	 * 视图名称
	 */
	public String designModel="DesignModel"+count;
	/**
	 * 用户名
	 */
	public String userName="hustar"+count;
	/**
	 * 用户名2
	 */
	public String userName2="hustar"+count2;
	/**
	 * 用户名3
	 */
	public String userName3="hustar"+count3;
	/**
	 * 用户名4
	 */
	public String userName4="hustar"+count4;
	/**
	 * 角色名称
	 */
	public String roleName="RoleName"+count;
	/**
	 * 会议名称
	 */
	public String meetingName="MeetingName"+count;
	/**
	 * 会议名称2
	 */
	public String meetingName2="MeetingName"+count2;
	/**
	 * 会议名称3
	 */
	public String meetingName3="MeetingName"+count3;
	/**
	 * 任务名称
	 */
	public String taskName="TaskName"+count;
	/**
	 * 任务名称2
	 */
	public String taskName2="TaskName"+count2;
	/**
	 * 任务名称3
	 */
	public String taskName3="TaskName"+count3;
	/**
	 * 任务名称4
	 */
	public String taskName4="TaskName"+count4;
	/**
	 * 计划名称
	 */
	public String planName="PlanName"+count;
	/**
	 * 计划名称2
	 */
	public String planName2="PlanName"+count2;
	/**
	 * 计划名称3
	 */
	public String planName3="PlanName"+count3;
	/**
	 * 问题描述
	 */
	public String problemDescription="ProblemDescription"+count;
	/**
	 * 专题会议1
	 */
	public String specialSession="SpecialSession"+count;
	/**
	 * 专题会议2
	 */
	public String specialSession2="SpecialSession"+count2;
	/**
	 * 周任务1
	 */
	public String weeklyTask="WeeklyTask"+count;
	/**
	 * 周任务2
	 */
	public String weeklyTask2="WeeklyTask"+count2;
	/**
	 * 周任务3
	 */
	public String weeklyTask3="WeeklyTask"+count3;
	/**
	 * 周任务4
	 */
	public String weeklyTask4="WeeklyTask"+count4;
	
	public static Random rd;
	
	public static synchronized Random getInstance() {
		if (rd == null) {
			rd = new Random();
		}
		return rd;
	}
}
