/*
 * Sonar, open source software quality management tool.
 * Copyright (C) 2008-2011 SonarSource
 * mailto:contact AT sonarsource DOT com
 *
 * Sonar is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * Sonar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Sonar; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.server.notifications.reviews;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.sonar.api.database.model.User;
import org.sonar.jpa.entity.Review;
import org.sonar.server.notifications.NotificationDispatcher;

public class CommentOnReviewCreatedByMeTest {

  private NotificationDispatcher.Context context;
  private CommentOnReviewCreatedByMe dispatcher;

  @Before
  public void setUp() {
    context = mock(NotificationDispatcher.Context.class);
    dispatcher = new CommentOnReviewCreatedByMe();
  }

  @Test
  public void shouldDispatchToCreator() {
    CommentOnReviewNotification notification = new CommentOnReviewNotification(new Review().setUserId(1), new User(), "comment");
    dispatcher.dispatch(notification, context);
    verify(context).addUser(1);

    notification = new CommentOnReviewNotification(new Review().setUserId(2), new User(), "comment");
    dispatcher.dispatch(notification, context);
    verify(context).addUser(2);
  }

}
