Standard Header
===============

If you have an HTML-format report using Bootstrap, you can include this standard
header at the top of your page. To use it:

1. Add this repo as a submodule of your report repo: `git submodule add https://github.com/AgoraNomic/Header.git`
2. As part of whatever script you use to generate the HTML report, include the content of `Header/header.html` in your report.
3. To highlight the correct section, replace `__ACTIVE_XXX__` (where `XXX` is the name of your repository, in all caps) with `active` in your script.