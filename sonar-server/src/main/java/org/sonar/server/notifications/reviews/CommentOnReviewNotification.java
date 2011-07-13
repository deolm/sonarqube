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

import org.sonar.api.database.model.User;
import org.sonar.jpa.entity.Review;
import org.sonar.server.notifications.Notification;

/**
 * @since 2.10
 */
public class CommentOnReviewNotification implements Notification {

  private Review review;
  private User author;
  private String comment;

  public CommentOnReviewNotification(Review review, User author, String comment) {
    this.review = review;
    this.author = author;
    this.comment = comment;
  }

  public Review getReview() {
    return review;
  }

  public User getAuthor() {
    return author;
  }

  public String getComment() {
    return comment;
  }

}
