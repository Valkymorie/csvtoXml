<users>
<#list userList>
<#items as user>
    <user>
        <username> ${user.userName} </username>
        <firstname> ${user.firstName} </firstname>
        <lastname> ${user.lastName} </lastname>
        <email> ${user.email} </email>
            <roles>
            <#list user.roles>
            <#items as r>
                <role> ${r} </role>
            </#items>
            </#list>
            </roles>
    </user>
</#items>
</#list>
</users>