package com.capgemini.devonfw.module.base.integration;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.devonfw.module.base.IntegrationTestApp;
import com.capgemini.devonfw.module.base.integration.handlers.SimpleMessageHandler;
import com.capgemini.devonfw.module.integration.common.api.Integration;

import io.oasp.module.test.common.base.ComponentTest;

/**
 * @author pparrado
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = IntegrationTestApp.class)
@ActiveProfiles("onedirection")
public class DefaultOneDirectionFlowTest extends ComponentTest {

  @Inject
  private Integration integration;

  @Autowired
  ConfigurableApplicationContext ctx;

  private final String qwerty = "qwerty";

  @Test
  public void sendMessageThroughDefaultSimpleChannel() throws InterruptedException {

    this.integration.subscribe(new SimpleMessageHandler());
    this.integration.send(this.ctx, this.qwerty);
    Thread.sleep(3000);
    assertThat(System.getProperty("test.message")).isEqualTo(this.qwerty);
  }

  @After
  public void end() {

    if (System.getProperty("test.message") != null)
      System.clearProperty("test.message");
  }

}
