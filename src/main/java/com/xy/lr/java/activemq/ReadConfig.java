 package com.xy.lr.java.activemq;



import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.io.PrintStream;

import java.net.URL;

import java.util.Properties;



public class ReadConfig

			{

				  private static Properties prop = null;

				  private static ReadConfig config = null;

				  private boolean loadFlag = false;

				  private ReadConfig() {

			      if (prop == null)

			    	  prop = new Properties();

				  }

				  private ReadConfig(String filePath) {

					  if (prop == null) {

						  prop = new Properties();

						  loadConfig(filePath);

					  }

				  }

				  public static ReadConfig getInstance(String filePath)

				  {

					  if (config == null) {

						  config = new ReadConfig(filePath);

					  }

					  return config;

				  }

				  public void loadConfig(String filePath) {

					  filePath = getFilePath(filePath);

					  try {

					  prop.load(new FileInputStream(filePath));

					  this.loadFlag = true;

					  } catch (FileNotFoundException e) {

						  e.printStackTrace();

					  } catch (IOException e) {

						 e.printStackTrace();

					  }

				  }

				  public Object getValue(String key) {

					  if (this.loadFlag) {

				      return prop.get(key);

					  }

					  throw new NullPointerException("please load config...");

				  }

 

				  /*private String getFilePath() {

					  return Thread.currentThread().getContextClassLoader().getResource("")

							  .getPath().substring(1);

				  }*/



				  private String getFilePath(String fileName)

				  {

					/*  if (System.getProperty("os.name").equals("Linux")) {

						  return "/" + getFilePath() + fileName;

					  }*/

					  //return getFilePath() + fileName;
					  return  fileName;

				  }
				  @Deprecated

				  protected void finalize() throws Throwable

				  {

					  System.out.println("release config ...");

					  prop = null;

				  }

			}