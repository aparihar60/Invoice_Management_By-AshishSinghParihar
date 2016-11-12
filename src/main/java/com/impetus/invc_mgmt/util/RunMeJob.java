package com.impetus.invc_mgmt.util;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

// TODO: Auto-generated Javadoc
/**
 * The Class RunMeJob.
 */
public class RunMeJob extends QuartzJobBean {

	/** The run me task. */
	private RunMeTask runMeTask;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org
	 * .quartz.JobExecutionContext)
	 */

	/**
	 * Gets the run me task.
	 * 
	 * @return the run me task
	 */
	public RunMeTask getRunMeTask() {
		return runMeTask;
	}

	/**
	 * Sets the run me task.
	 * 
	 * @param runMeTask
	 *            the new run me task
	 */
	public void setRunMeTask(RunMeTask runMeTask) {
		this.runMeTask = runMeTask;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org
	 * .quartz.JobExecutionContext)
	 */
	public void executeInternal(JobExecutionContext context)
			throws JobExecutionException {

		runMeTask.printMe();

	}

}
