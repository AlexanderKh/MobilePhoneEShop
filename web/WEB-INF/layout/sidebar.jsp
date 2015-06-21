<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    $(document).ready(function() {
        $('div.list-group').find('a[href="' + location.pathname + '"]')
                .closest('a').addClass('list-group-item active');
    });
</script>

<a href="<c:url value="/products"/>" class="text-center list-group-item">Products</a>