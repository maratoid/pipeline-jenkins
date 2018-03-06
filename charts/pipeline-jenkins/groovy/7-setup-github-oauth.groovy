/**
import jenkins.*
import hudson.*
import hudson.model.*
import jenkins.model.*
import hudson.security.SecurityRealm
import org.jenkinsci.plugins.GithubSecurityRealm
import org.jenkinsci.plugins.GithubAuthorizationStrategy
import hudson.security.AuthorizationStrategy

String githubWebUri = 'https://github.com template me'
String githubApiUri = 'https://api.github.com template me'
String clientID = 'template me'
String clientSecret = 'template me'
String oauthScopes = 'read:org'


// configure github security realm
SecurityRealm github_realm = new GithubSecurityRealm(githubWebUri, githubApiUri, clientID, clientSecret, oauthScopes)
//check for equality, no need to modify the runtime if no settings changed
if (!github_realm.equals(Jenkins.instance.getSecurityRealm())) {
    Jenkins.instance.setSecurityRealm(github_realm)
    Jenkins.instance.save()
}

// Configure authorization strategy

// permissions are ordered similar to web UI
// Admin User Names
String adminUserNames = 'template me'
// Participant in Organization
String organizationNames = 'template me'
// Use Github repository permissions
boolean useRepositoryPermissions = true
// Grant READ permissions to all Authenticated Users
boolean authenticatedUserReadPermission = true
// Grant CREATE Job permissions to all Authenticated Users
boolean authenticatedUserCreateJobPermission = false
// Grant READ permissions for /github-webhook
boolean allowGithubWebHookPermission = true
// Grant READ permissions for /cc.xml
boolean allowCcTrayPermission = false
// Grant READ permissions for Anonymous Users
boolean allowAnonymousReadPermission = false
// Grant ViewStatus permissions for Anonymous Users
boolean allowAnonymousJobStatusPermission = false
 
AuthorizationStrategy github_authorization = new GithubAuthorizationStrategy(adminUserNames,
    authenticatedUserReadPermission,
    useRepositoryPermissions,
    authenticatedUserCreateJobPermission,
    organizationNames,
    allowGithubWebHookPermission,
    allowCcTrayPermission,
    allowAnonymousReadPermission,
    allowAnonymousJobStatusPermission)
 
// check for equality, no need to modify the runtime if no settings changed
if (!github_authorization.equals(Jenkins.instance.getAuthorizationStrategy())) {
    Jenkins.instance.setAuthorizationStrategy(github_authorization)
    Jenkins.instance.save()
}
*/
