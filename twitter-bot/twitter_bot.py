import argparse
import openreview
import tweepy
import os

# API Key for Arr Preprints Bot
# Contact Stephen Mayhew (twitter: @mayhewsw) for the secrets
CONSUMER_KEY = "wjHFvsbNqcPjM8xh0VphoIfal"
CONSUMER_SECRET = os.environ['TWITTER_CONSUMER_SECRET']
ACCESS_TOKEN= "1395450619608113156-RxA4yS5IpHjAwEoiV87O8U8JeMmkQi"
ACCESS_TOKEN_SECRET = os.environ['TWITTER_ACCESS_TOKEN_SECRET']

def post_links(api: tweepy.API, year: int, month: str, dryrun: bool = False) -> None:
    """
    Given a tweepy API, this reads the links from the ACL OpenReview site and 
    posts them to twitter.
    :param api: an authenticated tweepy API
    :param year: integer year formatted as YYYY
    :param month: string month represented with 3 characters
    returns None
    """
    guest_client = openreview.Client(baseurl='https://api.openreview.net')
    invitation = f"aclweb.org/ACL/ARR/{year}/{month}/-/Blind_Submission"

    blind_submissions = guest_client.get_notes(
            invitation=invitation)

    print(f"Retrieved {len(blind_submissions)} submissions from OpenReview for {month} {year}")

    for bs in blind_submissions:
        content = bs.content
        paper_id = bs.id

        title = content["title"]
        paper_link = f"https://openreview.net/pdf?id={paper_id}"
        forum_link = f"https://openreview.net/forum?id={paper_id}"

        # the forum link sends to you a landing page for the paper.
        tweet = f"{title} {forum_link}"
        if dryrun:
            print(tweet)
        else:
            api.update_status(tweet)


def oauth_login():
    """Authenticate with twitter using OAuth"""

    # Authenticate to Twitter
    auth = tweepy.OAuthHandler(CONSUMER_KEY, CONSUMER_SECRET)
    auth.set_access_token(ACCESS_TOKEN, ACCESS_TOKEN_SECRET)

    # Create API object
    return tweepy.API(auth)


def batch_delete(api):
    print("You are about to delete all tweets from the account @%s." % api.verify_credentials().screen_name)
    print("Does this sound ok? There is no undo! Type yes to carry out this action.")
    do_delete = input("> ")
    if do_delete.lower() == 'yes':
        for status in tweepy.Cursor(api.user_timeline).items():
            try:
                api.destroy_status(status.id)
                print("Deleted:", status.id)
            except Exception:
                print("Failed to delete:", status.id)


if __name__ == "__main__":
     
    parser = argparse.ArgumentParser()
    parser.add_argument("command", help="Whether to post or delete all tweets", choices=["post", "delete"], type=str)
    parser.add_argument("--year", help="This should have 4 digits: 2021", type=int)
    parser.add_argument("--month", help="This should be three letters: May, Jun, Jul, etc.", type=str)
    parser.add_argument("--dryrun", help="Just print links instead of posting", action="store_true", default=False)

    args = parser.parse_args()

    api = oauth_login()
    print("Authenticated as: %s" % api.me().screen_name)

    if args.command == "delete":
        print("deleting")
        # batch_delete(api) 
    elif args.command == "post":
        if not (args.year and args.month):
            print("Must include year and month with posting!")
        else:
            post_links(api, args.year, args.month, args.dryrun)
        pass
    else:
        print("Shouldn't ever get here...")
